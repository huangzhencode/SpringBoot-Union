package com.java.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Objects;

/**
 * lombok
 * 如果不想每次都写
 * private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
 * 可以用注解@Slf4j;
 */
@Slf4j
@Configuration
public class ESRestClient {

    //用于判断以：分割后 存储IP地址：端口号 的 数组  是否长度为2 （即判断格式是否正确）
    private static final int ADDRESS_LENGTH = 2;
    //协议类型
    private static final String HTTP_SCHEME = "http";

    //和application.yml 中的属性绑定
    @Value("${elasticsearch.host}")
    String ipAddress;
    @Value("${elasticsearch.user}")
    private String userName;
    @Value("${elasticsearch.password}")
    private String password;

    //获取elasticsearch的集群中各个IP地址
    @Bean
    public RestClientBuilder restClientBuilder() {
        String[] split = ipAddress.split(",");
        HttpHost[] hosts = Arrays.stream(split)
                .map(this::makeHttpHost)
                .filter(Objects::nonNull)
                .toArray(HttpHost[]::new);
        return RestClient.builder(hosts);
    }

    @Bean(name = "highLevelClient")
    public RestHighLevelClient highLevelClient(@Autowired RestClientBuilder restClientBuilder){
        //配置身份验证
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));
        restClientBuilder.setHttpClientConfigCallback(
                httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        //设置连接超时和套接字超时
        restClientBuilder.setRequestConfigCallback(
                requestConfigBuilder -> requestConfigBuilder.setSocketTimeout(10000).setConnectTimeout(60000));
        //配置HTTP异步请求ES的线程数
        restClientBuilder.setHttpClientConfigCallback(
                httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultIOReactorConfig(
                        IOReactorConfig.custom().setIoThreadCount(1).build()));
        //设置监听器，每次节点失败都可以监听到，可以作额外处理
        restClientBuilder.setFailureListener(new RestClient.FailureListener() {
            @Override
            public void onFailure(Node node) {
                super.onFailure(node);
                log.error(node.getHost() + "--->该节点失败了");
            }
        });
        return new RestHighLevelClient(restClientBuilder);
    }

    private HttpHost makeHttpHost(String str) {
        assert StringUtils.isNotEmpty(str);
        String[] address = str.split(":");
        //传入的是IP地址：端口号  以：分割长度是2
        if (address.length == ADDRESS_LENGTH) {
            String ip = address[0];
            int port = Integer.parseInt(address[1]);
            log.info("ES连接的ip:{},port:{}", ip, port);
            //获得连接
            return new HttpHost(ip, port, HTTP_SCHEME);
        } else {
            log.error("传入的ip参数不正确！");
            return null;
        }
    }


}

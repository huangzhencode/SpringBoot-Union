package com.java.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.java.injector.MySqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhen
 * @create 2020-03-23 21:52
 */
@Configuration
public class MybatisConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }



    //执行分析插件
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> list = new ArrayList<>();
        //攻击SQL阻断解析器
        list.add(new BlockAttackSqlParser());
        sqlExplainInterceptor.setSqlParserList(list);

        return sqlExplainInterceptor;
    }

//    //性能分析插件  3.2版本后弃用  改用p6spy
//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }

    //乐观锁插件：防止并发情况下，数据改动问题
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){

        return new OptimisticLockerInterceptor();
    }

    //Sql注入器
    @Bean
    public MySqlInjector mySqlInjector(){
        return new MySqlInjector();
    }
}

package com.wuzh.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wuzh.blog.dao.mapper.*;
import com.wuzh.blog.dao.pojo.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("store")
@Log
public class Hello {
    // 每次都查询第一个数据，之后删除这条数据
    @Autowired
    private BotMapper bot ;
    @Autowired
    private BotMapper11269741 bot11269741 ;
    
    @Autowired
    private BotMapper11322167 bot11322167;
    
    @Autowired
    private BotMapper11322253 bot11322253;

    @Autowired
   private BotMapper11269987 bot11269987;

    @Autowired
    private  BotMapper11427021 bot11427021;

    @Autowired
    private BotMapper11276616 bot11276616;

    @Autowired
    private BotMapper11258646 bot11258646;

    @Autowired
    private BotMapper11391347 bot11391347;

    @Autowired BotMapper11527884 bot11527884;

    @Autowired
    private BotMapper11257988  bot11257988;

    @Autowired
    private BotMapper11257604 bot11257604;

    @Autowired BotMapper11265386 bot11265386;
    
    @Autowired BotMapper11265427 bot11265427;

    @Autowired BotMapper11259132 bot11259132;

    @Autowired BotMapper11252670 bot11252670;
    @GetMapping("id11641418")
    public String index1(){
        boolean hh =true;
        int id = 0;
        Random r = new Random();
        Bot bot1 = null;
        QueryWrapper<Bot> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot> bots = bot.selectList(botQuery);
        for (Bot b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot.delete(botQueryWrapper);
        System.out.println(delete);

//        }
        return bot1.getToken();
    }
    @GetMapping("id11269747")
    public String index2(){
        boolean hh =true;
        int id = 0;
        Random r = new Random();
        Bot11269747 bot1 = null;
        QueryWrapper<Bot11269747> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11269747> bots = bot11269741.selectList(botQuery);
        for (Bot11269747 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11269747> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11269741.delete(botQueryWrapper);
        System.out.println(delete);

//        }
        return bot1.getToken();
    }
    @GetMapping("id11322167")
    public String index3(){
      
        int id = 0;
        Random r = new Random();
        Bot11322167 bot1 = null;
        QueryWrapper<Bot11322167> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11322167> bots = bot11322167.selectList(botQuery);
        for (Bot11322167 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11322167> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11322167.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
//        }
    }
    @GetMapping("id11322253")
    public String index4(){
        int id = 0;
        Random r = new Random();
        Bot11322253 bot1 = null;
        QueryWrapper<Bot11322253> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11322253> bots = bot11322253.selectList(botQuery);
        for (Bot11322253 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11322253> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11322253.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11269987")
    public String index5(){
        int id = 0;
        Random r = new Random();
        Bot11269987 bot1 = null;
        QueryWrapper<Bot11269987> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11269987> bots = bot11269987.selectList(botQuery);
        for (Bot11269987 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11269987> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11269987.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11427021")
    public String index6(){
        int id = 0;
        Random r = new Random();
        Bot11427021 bot1 = null;
        QueryWrapper<Bot11427021> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11427021> bots = bot11427021.selectList(botQuery);
        for (Bot11427021 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11427021> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11427021.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11276616")
    public String index7(){
        int id = 0;
        Random r = new Random();
        Bot11276616 bot1 = null;
        QueryWrapper<Bot11276616> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11276616> bots = bot11276616.selectList(botQuery);
        for (Bot11276616 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11276616> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11276616.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }

    @GetMapping("id11258646")
    public String index8(){
        int id = 0;
        Random r = new Random();
        Bot11258646 bot1 = null;
        QueryWrapper<Bot11258646> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11258646> bots = bot11258646.selectList(botQuery);
        for (Bot11258646 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11258646> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11258646.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11391347")
    public String index9(){
        int id = 0;
        Random r = new Random();
        Bot11391347 bot1 = null;
        QueryWrapper<Bot11391347> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11391347> bots = bot11391347.selectList(botQuery);
        for (Bot11391347 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11391347> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11391347.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11527884")
    public String index10(){
        int id = 0;
        Random r = new Random();
        Bot11527884 bot1 = null;
        QueryWrapper<Bot11527884> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11527884> bots = bot11527884.selectList(botQuery);
        for (Bot11527884 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11527884> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11527884.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11257988")
    public String index11(){
        int id = 0;
        Random r = new Random();
        Bot11257988 bot1 = null;
        QueryWrapper<Bot11257988> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11257988> bots = bot11257988.selectList(botQuery);
        for (Bot11257988 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11257988> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11257988.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11257604")
    public String index12(){
        int id = 0;
        Random r = new Random();
        Bot11257604 bot1 = null;
        QueryWrapper<Bot11257604> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11257604> bots = bot11257604.selectList(botQuery);
        for (Bot11257604 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11257604> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11257604.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11265386")
    public String index13(){
        int id = 0;
        Random r = new Random();
        Bot11265386 bot1 = null;
        QueryWrapper<Bot11265386> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11265386> bots = bot11265386.selectList(botQuery);
        for (Bot11265386 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11265386> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11265386.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11265427")
    public String index14(){
        int id = 0;
        Random r = new Random();
        Bot11265427 bot1 = null;
        QueryWrapper<Bot11265427> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11265427> bots = bot11265427.selectList(botQuery);
        for (Bot11265427 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11265427> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11265427.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
    @GetMapping("id11259132")
    public String index15() {
        int id = 0;
        Random r = new Random();
        Bot11259132 bot1 = null;
        QueryWrapper<Bot11259132> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11259132> bots = bot11259132.selectList(botQuery);
        for (Bot11259132 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11259132> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11259132.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
        //*[@id="app"]/div[1]/div[1]/div/div[2]/div/span[2]/a}
        //*[@id="app"]/div[1]/div[1]/div/div[1]/div/span[2]/a
    @GetMapping("id11252670")
    public String index16(){
        int id = 0;
        Random r = new Random();
        Bot11252670 bot1 = null;
        QueryWrapper<Bot11252670> botQuery = new QueryWrapper<>();
        botQuery.last("limit 1");
        List<Bot11252670> bots = bot11252670.selectList(botQuery);
        for (Bot11252670 b :
                bots) {
            bot1=b;
        }
        QueryWrapper<Bot11252670> botQueryWrapper = new QueryWrapper<>();

        botQueryWrapper.last("limit 1");
        int delete = bot11252670.delete(botQueryWrapper);
        System.out.println(delete);
        return bot1.getToken();
    }
}

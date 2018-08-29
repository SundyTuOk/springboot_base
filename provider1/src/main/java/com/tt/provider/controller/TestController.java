package com.tt.provider.controller;

import com.github.pagehelper.PageHelper;
import com.tt.provider.dao.PluginMapper;
import com.tt.provider.entity.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private PluginMapper pluginMapper;

    /*@RequestMapping("test1")
    public Result test1() {
        PageHelper.startPage(2, 2);
        List<Plugin> plugins = pluginMapper.selectAll();
        Plugin plugin = plugins.get(11);
        return ResultUtils.ok(plugin);
    }*/

    @RequestMapping("test1")
    public String test1() {
        PageHelper.startPage(2, 2);
        List<Plugin> plugins = pluginMapper.selectAll();
        Plugin plugin = plugins.get(0);
        int i = 1/0;
        return plugin.getName();
    }

}

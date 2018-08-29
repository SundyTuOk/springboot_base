package com.tt.provider.dao;

import com.tt.demodao.mapper.Mapper;
import com.tt.provider.entity.Plugin;
import org.springframework.stereotype.Repository;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface PluginMapper extends Mapper<Plugin> {
}
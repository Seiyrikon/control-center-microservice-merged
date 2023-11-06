package com.example.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.ProjInfoOutput;


@Mapper
public interface ProjInfoDao {

    List<ProjInfoOutput> getAllProjInfo();

    ProjInfoOutput getProjInfoById(String id);

}
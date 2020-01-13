package com.zrt.hi.repository;

import com.zrt.hi.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HiRepository extends JpaRepository<Stu,Integer> {//写类名和主键类型

}

package com.imooc.girl.service;

import com.imooc.girl.Exception.GirlException;
import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    //数据库事务操作的注解
    //@Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBB");
        girlRepository.save(girlB);
    }

    public Result<Integer>  getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age  =  girl.getAge();
        if(age < 10){
            //返回你可能还在上小学
            throw new GirlException(ResultEnum.PRIMARY);
        }
        else if(age <16) {
            //返回你可能还在上高中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        else{
            return ResultUtil.success(age);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}

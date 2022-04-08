package com.xule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xule.dao.CarouselMapper;
import com.xule.entity.Carousel;
import com.xule.service.CarouselService;
import com.xule.vo.DataVO;
import com.xule.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Integer id) {
        //返回给前端的结果
        ResultVO resultVo;

        //分页相关的参数
        DataVO<Carousel> carouselDataVO;

        //结果中data对应的用户数组
        List<Carousel> carousels;

        //说明传递了id，那就是findById
        if (id!=null){
            carousels=new ArrayList<>();
            //查询
            Carousel carousel = carouselMapper.selectByPrimaryKey(id);

            //没有查到用户的情况
            if (carousel==null){
                carouselDataVO =new DataVO<>(0L,carousels,pageNum,pageSize);

                resultVo=new ResultVO(4000,"查无此图!",false, carouselDataVO);
            }else {
                //查到了用户扔到集合中
                carousels.add(carousel);

                carouselDataVO =new DataVO<>(1L,carousels,pageNum,pageSize);

                resultVo=new ResultVO(1000,"查到了该图!",true, carouselDataVO);

            }
        }else {
            //开启分页
            PageHelper.startPage(pageNum,pageSize);

            carousels= carouselMapper.selectByExample(null);

            //如果数据库是空的，一个人都没查到
            if (carousels.size()==0){
                carouselDataVO =new DataVO<>(0L,carousels,pageNum,pageSize);

                resultVo=new ResultVO(4100,"啥都没!!!",false, carouselDataVO);
                //查到了
            }else {
                //封装pageInfo，为了获取总数据量
                PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);

                carouselDataVO =new DataVO<>(pageInfo.getTotal(),carousels,pageNum,pageSize);

                resultVo=new ResultVO(1100,"轮播图查询成功！！！",true, carouselDataVO);


            }

        }
        return resultVo;
    }
}

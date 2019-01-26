package com.BoeYu.service.impl;

import com.BoeYu.mapper.DiscountMapper;
import com.BoeYu.pojo.Discount;
import com.BoeYu.pojo.DiscountExample;
import com.BoeYu.service.DiscounService;
import com.BoeYu.util.MyUtil;
import com.BoeYu.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscounServiceImpl implements DiscounService {
    @Autowired
    private DiscountMapper discountMapper;
    @Override
    public String addDiscoun(String csize, String distype, String endtime) {
        int cg=0;
        int sb=0;
        for (int i=0;i<Integer.valueOf(csize);i++){
            Discount discount  = new  Discount();
            discount.setCreatetime(new Date());
            discount.setOrderr(MyUtil.getOrderIdByUUId());
            discount.setOrderid(MyUtil.OrderIdByUUId());
            discount.setDistype(distype);
            discount.setEndtime(endtime);
            discount.setType("0");
            discount.setFlag("0");
            discount.setExport("0");
            if (discountMapper.insert(discount)>0){
                cg++;
            }else{
                sb++;
            }
        }
        String msg = "充值卡生成成功"+cg+"条，失败"+sb+"条";
        return msg;
    }

    @Override
    public ResultUtil selDiscoun(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        DiscountExample example = new DiscountExample();
        example.setOrderByClause("createtime DESC");
        List<Discount> list = discountMapper.selectByExample(example);
        PageInfo<Discount> pageInfo = new PageInfo<Discount>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public int updateExport(String[] id) {
        return discountMapper.updateExport(id);
    }
}

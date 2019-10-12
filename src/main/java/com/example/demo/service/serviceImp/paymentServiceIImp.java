package com.example.demo.service.serviceImp;

import com.example.demo.dao.paymentDao;
import com.example.demo.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 14:00
 * @Description:
 */
@Service
public class paymentServiceIImp implements paymentService {
   @Autowired
    private  paymentDao paymentDao;
    @Override
    public String testDate() {

        return paymentDao.getsystemDate();
    }
}

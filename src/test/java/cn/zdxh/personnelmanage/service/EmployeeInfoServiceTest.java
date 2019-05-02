package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.EmployeeInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeInfoServiceTest {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Test
    public void testSelectAll(){
        List<EmployeeInfo> allEmployees = employeeInfoService.findAllEmployees(0, 1);
        log.info("allEmployees = {}",allEmployees);
    }
}

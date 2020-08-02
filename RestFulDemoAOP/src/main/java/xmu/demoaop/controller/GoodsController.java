package xmu.demoaop.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xmu.demoaop.annotation.Audit;
import xmu.demoaop.domain.Goods;
import xmu.demoaop.service.GoodsService;
import xmu.demoaop.util.ResponseUtil;


@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/wx/goods", produces = "application/json;charset=UTF-8")
@Validated
public class GoodsController {

    private final Log logger = LogFactory.getLog(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @GetMapping("{id}/detail")
    public Object getDetail(@PathVariable("id") Integer id) {

        Goods goods = goodsService.findById(id);
        return ResponseUtil.ok(goods);
    }

    @RequestMapping("search")
    public Object search(@RequestParam String name) {

        Goods goods = goodsService.searchByName(name);
        return ResponseUtil.ok(goods);
    }

    @PostMapping("")
    @Audit(login = true, userType = 0)
    public Object createGood(@RequestBody Goods goods){
        Goods new_goods = goodsService.create(goods);
        return ResponseUtil.ok(new_goods);
    }
}

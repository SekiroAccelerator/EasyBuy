package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Product;
import pojo.Product_Category;
import service.ProductService;
import service.Product_CategoryService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Product_CategoryController {
    @Resource
    private Product_CategoryService service;
    @Resource
    private ProductService productService;

    /**
     * 分类登记查询
     * @param type
     * @return
     */
    @RequestMapping("category")
    @ResponseBody
    public List<Product_Category> productType(@RequestParam Integer type){
        return service.type(type);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    @RequestMapping("categoryById")
    @ResponseBody
    public Product_Category category(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }

    /**
     * 修改分类
     * @param product_category
     * @return
     */
    @RequestMapping("categoryUpdate")
    @ResponseBody
    public boolean categoryUpdate(Product_Category product_category){
        return service.updateByPrimaryKeySelective(product_category)>0;
    }

    /**
     * id查询
     * @param id
     * @return
     */
    @RequestMapping("category1by3")
    @ResponseBody
    public Integer onByThree(@RequestParam Integer id){
        return service.oneByThree(id);
    }

    /**
     * id删除
     * @param id
     * @return
     */
    @RequestMapping("categoryDel")
    @ResponseBody
    public Map<String,String> categoryDel(@RequestParam Integer id){
        Map<String,String> map =new HashMap<>();
        Product_Category category=service.selectByPrimaryKey(id);
        if (category.getType()==1){
            System.out.println(service.typeSon(category.getId()));
            if (service.typeSon(category.getId()).isEmpty()){
                if (service.deleteByPrimaryKey(id)>0){
                    map.put("message", "删除成功");
                }else {
                    map.put("message", "删除失败,原因不明!");
                }
            }else {
                map.put("message", "此分类下还有二级分类,无法删除!");
            }
        }else if (category.getType()==2){
            if (service.typeSon(category.getId()).isEmpty()){
                if (service.deleteByPrimaryKey(id)>0){
                    map.put("message", "删除成功");
                }else {
                    map.put("message", "删除失败,原因不明!");
                }
            }else {
                map.put("message", "此分类下还有三级分类,无法删除!");
            }
        }else {
            if (productService.selectLv3(id)==null){
                if (service.deleteByPrimaryKey(id)>0){
                    map.put("message", "删除成功");
                }else {
                    map.put("message", "删除失败,原因不明!");
                }
            }else {
                map.put("message", "此分类下还有商品,无法删除!");
            }
        }
        return map;
    }

    /**
     * 子级查询
     * @param parentId
     * @return
     */
    @RequestMapping("categorySon")
    @ResponseBody
    public List<Product_Category> productTypeSon(@RequestParam Integer parentId){
        return service.typeSon(parentId);
    }

    /**
     * 修改分类
     * @param product_category
     * @return
     */
    @RequestMapping("categoryAdd")
    @ResponseBody
    public boolean categoryAdd(Product_Category product_category){
        return service.insertSelective(product_category)>0;
    }


    /**
     * 根据品牌id查询该品牌的信息
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public Product_Category selectById(@RequestParam(value = "id") Integer id){
        return service.selectByPrimaryKey(id);
    }

    /**
     * 根据品牌id查询5个该品牌的商品（品牌为3级）
     * @param id
     * @return
     */
    @RequestMapping("/selectCategoryByid")
    @ResponseBody
    public List<Product_Category> selectCategoryByid(@RequestParam(value = "id") Integer id){
        Integer shuliang = 5;
        return service.selectCategoryByid(id,shuliang);
    }

    /**
     * 根据品牌id查询3个该品牌的商品（品牌为3级）
     * @param id
     * @return
     */
    @RequestMapping("/selectCategoryByid2")
    @ResponseBody
    public List<Product_Category> selectCategoryByid2(@RequestParam(value = "id") Integer id){
        Integer shuliang = 3;
        return service.selectCategoryByid(id,shuliang);
    }

    /**
     * 查询所有一级分类
     * @return
     */
    @RequestMapping("/selectAllOneId")
    @ResponseBody
    public List<Product_Category> selectAllOneId(){
        return service.selectAllOneId();
    }

    /**
     * 根据一级id查询所有三级分类
     * @param id
     * @return
     */
    @RequestMapping("/selectAllTwoIdByOneId")
    @ResponseBody
    public List<Product_Category> selectAllTwoIdByOneId(@RequestParam(value = "id") Integer id){
        return service.selectAllTwoIdByOneId(id);
    }

    /**
     * 根据品牌id查询6个该品牌的商品（品牌为3级）
     * @param id
     * @return
     */
    @RequestMapping("/selectCategoryByid3")
    @ResponseBody
    public List<Product_Category> selectCategoryByid3(@RequestParam(value = "id") Integer id){
        Integer shuliang = 6;
        return service.selectCategoryByid(id,shuliang);
    }
}

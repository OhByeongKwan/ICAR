package com.example.icar.controller;

import com.example.icar.domain.*;
import com.example.icar.service.MainService;
import com.example.icar.util.FileHandler;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class mainApiController {
    private final MainService mainService;
    private final FileHandler fileHandler;

    @PostMapping("/insertItem")
//    public String  insertItem(@ModelAttribute AddItem item){
    public String  insertItem(@Validated @RequestParam("imgName") List<MultipartFile> imgName,
                              @RequestParam("inventory") String inventory,
                              @RequestParam("type") String type,
                              @RequestParam("name") String name,
                              @RequestParam("code") String code,
                              @RequestParam("year") String year,
                              @RequestParam("location") String location,
                              @RequestParam("note") String note) throws Exception{

        List<Img> imgList = mainService.addImg(imgName);

        AddItem addItem = new AddItem();
        addItem.setInventory(inventory);
        addItem.setType(type);
        addItem.setName(name);
        addItem.setCode(code);
        addItem.setYear(year);
        addItem.setLocation(location);
        addItem.setNote(note);

        for (Img img : imgList) {
            addItem.setImgName(img.getImgName());
            addItem.setStoreName(img.getStoreName());
            addItem.setImgPath(img.getImgPath());
        }

        System.out.println(addItem);

        return mainService.insertItem(addItem);
    }

    @GetMapping("/getItemAll")
    public List<Item> getAll(){
        return mainService.getAll();
    }

    @DeleteMapping("/deleteItem/{idx}")
    public String deleteItem(@PathVariable Long idx){
        return mainService.deleteItem(idx);
    }

    @PostMapping("/editItem")
    public String editItem(@ModelAttribute EditItem editItem){
        return mainService.editItem(editItem);
    }
}

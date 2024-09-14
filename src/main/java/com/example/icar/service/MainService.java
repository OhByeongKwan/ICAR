package com.example.icar.service;

import com.example.icar.domain.AddItem;
import com.example.icar.domain.EditItem;
import com.example.icar.domain.Img;
import com.example.icar.domain.Item;
import com.example.icar.repasitory.MainRepository;
import com.example.icar.util.FileHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class MainService {
    private final MainRepository mainRepository;
    private final FileHandler fileHandler;

    public String insertItem(AddItem item){
        Item newItem = new Item();

        newItem.setInventory(item.getInventory());
        newItem.setType(item.getType());
        newItem.setCode(item.getCode());
        newItem.setYear(item.getYear());
        newItem.setLocation(item.getLocation());
        newItem.setNote(item.getNote());
        newItem.setName(item.getName());
        newItem.setImgName(item.getImgName());
        newItem.setStoreName(item.getStoreName());
        newItem.setImgPath(item.getImgPath());

        mainRepository.save(newItem);
        return "저장 성공";
    }

    public List<Img> addImg(List<MultipartFile> img) throws Exception{
// 파일을 저장하고 그 Board 에 대한 list 를 가지고 있는다
        List<Img> list = fileHandler.parseFileInfo(img);

//        if (list.isEmpty()){
//            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
//        }
//        // 파일에 대해 DB에 저장하고 가지고 있을 것
//        else{
//            List<Img> pictureBeans = new ArrayList<>();
////            for (Img img : list) {
////                pictureBeans.add(mainRepository.save(img));
////            }
//        }
        return list;
    }

    public List<Item> getAll(){
        return mainRepository.findAll();
    }

    public String deleteItem(Long idx){
        Optional<Item> item = mainRepository.findById(idx);

        String absolutePath = new File("").getAbsolutePath() + "/";
        String path = item.get().getImgPath();
        String img_store_name = item.get().getStoreName();

        // 전체 경로를 생성합니다.
        File fileToDelete = new File(absolutePath + path + "/" + img_store_name);

        fileToDelete.delete();

        mainRepository.deleteById(item.get().getIdx());
        return "삭제 성공";
    }

    public String editItem(EditItem editItem){
        Optional<Item> item = mainRepository.findById(editItem.getIdx());
        Item oldItem = item.get();

        oldItem.setInventory(editItem.getInventory());
        oldItem.setType(editItem.getType());
        oldItem.setName(editItem.getName());
        oldItem.setCode(editItem.getCode());
        oldItem.setYear(editItem.getYear());
        oldItem.setLocation(editItem.getLocation());
        oldItem.setNote(editItem.getNote());

        return "수정 성공";
    }
}

package com.example.icar.util;

import com.example.icar.domain.Img;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileHandler {
    public List<Img> parseFileInfo(List<MultipartFile> multipartFiles) throws Exception {

        // 반환을 할 파일 리스트
        List<Img> fileList = new ArrayList<>();

        // 파일이 빈 것이 들어오면 빈 것을 반환
        if (multipartFiles.isEmpty()) {
            return fileList;
        }
        // 파일 이름을 업로드 한 날짜로 바꾸어서 저장할 것이다
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        String current_date = simpleDateFormat.format(new Date());

        // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)
        String absolutePath = new File("").getAbsolutePath() + "/";

        // 경로를 지정하고 그곳에다가 저장
        String path = "src/main/resources/static/uploads";
//        String path = "src/main/resources/templates/images";
//        String path2 = "build/resources/main/templates/images";
//        current_date 일단 생략
        File file = new File(path);
        // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if (!file.exists()) {
            // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }

        // 파일들을 이제 만져볼 것이다
        for (MultipartFile multipartFile : multipartFiles) {
            // 파일이 비어 있지 않을 때 작업을 시작해야 오류가 나지 않는다
            if (!multipartFile.isEmpty()) {
                // jpeg, png, gif 파일들만 받아서 처리할 예정
                String contentType = multipartFile.getContentType();
                String originalFileExtension;
                // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {
                    if (contentType.contains("image/jpeg")) {
                        originalFileExtension = ".jpg";
                    } else if (contentType.contains("image/png")) {
                        originalFileExtension = ".png";
                    } else if (contentType.contains("image/gif")) {
                        originalFileExtension = ".gif";
                    }
                    // 다른 파일 명이면 아무 일 하지 않는다
                    else {
                        break;
                    }
                }
                //현재 타임 가져와서 캐싱 문제 해결하는 코드
//                String timestamp = String.valueOf(System.currentTimeMillis());
                // 각 이름은 겹치면 안되므로 나노 초까지 동원하여 지정
                String new_file_name = System.nanoTime() + originalFileExtension;
//                String new_file_name = System.nanoTime() + timestamp + originalFileExtension;
                // 생성 후 리스트에 추가
                Img item = createBoardObject(multipartFile, path, new_file_name);
//                Board board = Board.builder()
//                        .originalFileName(multipartFile.getOriginalFilename())
//                        .storedFileName(path + "/" + new_file_name)
//                        .fileSize(multipartFile.getSize())
//                        .createDate(LocalDateTime.now())
//                        .build();
                fileList.add(item);

                // 저장된 파일로 변경하여 이를 보여주기 위함
                file = new File(absolutePath + path + "/" + new_file_name);
                multipartFile.transferTo(file);
            }
        }
        return fileList;
    }
    private Img createBoardObject(MultipartFile multipartFile, String path, String new_file_name) {
        return Img.builder()
                .imgName(multipartFile.getOriginalFilename())
                .storeName(new_file_name)
                .imgPath(path)
                .build();
    }
}

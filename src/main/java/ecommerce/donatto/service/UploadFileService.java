package ecommerce.donatto.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class UploadFileService {
    private String folder="/uploads/**";

    public void deleteImage(String name) {
        String ruta="C:\\Users\\Usuario\\Desktop\\e-commerce\\backend\\donatto\\uploads";
        File file = new File(ruta+name);
        file.delete();
    }
}

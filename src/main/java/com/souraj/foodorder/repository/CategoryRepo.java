/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.souraj.foodorder.repository;

import com.souraj.foodorder.model.Category;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ksouraj
 */
@Stateless
public class CategoryRepo extends GenericAbstractClasss<Category> {

    @PersistenceContext(name = "EPE")
    private EntityManager em;

    public CategoryRepo() {
        super(Category.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;

    }

    public String saveUploadedFile(UploadedFile uploadedFile) {
        System.out.println("uploadedFile :" + uploadedFile);
        if (uploadedFile != null) {
            try {
                String uploadFolderPath = "/home/ksouraj/Uploads";
                Path folderPath = Paths.get(uploadFolderPath);
                Files.createDirectories(folderPath);
                OutputStream output = new FileOutputStream(new File(uploadFolderPath, uploadedFile.getFileName()));
                IOUtils.copy(uploadedFile.getInputstream(), output);
                System.out.println("Completed");
                return "/Uploads/" + uploadedFile.getFileName();
            } catch (IOException e) {
                FacesMessage message = new FacesMessage("Error", "Error while uploading the file.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        return null;
    }

    public void deleteFile(String filePath) {
        try {
            Path fileToDelete = Paths.get(filePath);
            Files.deleteIfExists(fileToDelete);
        } catch (IOException e) {
            FacesMessage message = new FacesMessage("Error", "Error while deleting the file.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}

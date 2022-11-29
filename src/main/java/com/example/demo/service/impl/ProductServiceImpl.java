package com.example.demo.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Product;
import com.example.demo.entity.brand;
import com.example.demo.entity.detailsCategories;
import com.example.demo.entity.discount;
import com.example.demo.entity.image;
import com.example.demo.responsitory.brandRepository;
import com.example.demo.responsitory.detailsCateRepository;
import com.example.demo.responsitory.imageRepository;
import com.example.demo.responsitory.productRepository;
import com.example.demo.service.productService;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ProductServiceImpl implements productService {
	
	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private brandRepository brandRepo;
	
	@Autowired
	private detailsCateRepository detailsCate;
	
	@Autowired
	private imageRepository imageRepo;

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
		 
	}

	@Override
	public void savePro(MultipartFile file,String name,double price,String description,int quantity,int brand, int categories)
	{
		Product p = new Product();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		p.setName(name);
		p.setPrice(price);
		p.setDescription(description);
		p.setQuantity(quantity);
        addCategoriesToPro(p, categories);
        addBrandToPro( p, brand);
        p.setQuantity(quantity);
        p.setNewP(0);
//        discount d = new discount();
//        d.setPercent(0);
//        p.setIdDiscount(d);
        productRepo.save(p);
        addImageToProduct( p, file);
	}
	
	public void addImageToProduct(Product p,MultipartFile file) {
		if (file == null) {
			System.out.println("khong co anh!!");
			return;
		}else {
			
			image i = new image();
			i.setIdProduct(p);
			
			//byte[] endcode = Base64.getEncoder().encode(file.getBytes());
			try {
				String imageData = resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400);
				//i.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
				
				
				byte[] byteData = imageData.getBytes();
				
				
				Blob blob;
				try {
					blob = new SerialBlob(byteData);
					i.setImage(blob);
				} catch (SerialException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageRepo.save(i);
			System.out.println("them anh thah cong");
		}
	}
	public void addCategoriesToPro(Product p,int id) {
		detailsCategories d = detailsCate.findById(id).get();
		p.setIdCate(d);
	}
	public void addBrandToPro(Product p,int id) {
		brand b = brandRepo.findById(id).get();
		p.setIdBrand(b);
	}

	public String resizeImageForUse(String src,int width, int height) {
		BufferedImage image = base64ToBufferedImage(src);
		try {
			image = resizeImage(image, width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return bufferedImageTobase64(image);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private BufferedImage base64ToBufferedImage(String base64Img) {
		BufferedImage image = null;
		byte[] decodedBytes = Base64.getDecoder().decode(base64Img);
		
		try {
			image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	private  BufferedImage resizeImage(BufferedImage image , int width , int height) throws IOException {
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		try {
			Thumbnails.of(image).size(width, height).outputFormat("JPEG").outputQuality(1).toOutputStream(outputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] data = outputstream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		return ImageIO.read(inputStream);
	}
	
	private String bufferedImageTobase64(BufferedImage image ) throws UnsupportedEncodingException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", Base64.getEncoder().wrap(out));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toString(StandardCharsets.ISO_8859_1.name());
	}
	@Override
	public void deletePro(Integer id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public void updatePro(String encodeBase64,int id,String name,double price,String description,int quantity,int brand, int categories) throws SerialException, SQLException {
		
		if (encodeBase64 !=null) {
			Product p = productRepo.findById(id).get();
			p.setName(name);
			p.setPrice(price);
			p.setDescription(description);
			p.setQuantity(quantity);
			addCategoriesToPro(p, categories);
			addBrandToPro( p, brand);
			p.setQuantity(quantity);
			p.setNewP(0);
			if (!encodeBase64.contains("empty.png")) {
				byte[] byteData = encodeBase64.getBytes();
				Blob blob;
				blob = new SerialBlob(byteData);
				p.getImage().get(0).setImage(blob);
			}
			productRepo.save(p);
		}
	}

	@Override
	public Optional<Product> findByIdPro(Integer id) {
		
		return productRepo.findById(id);
	}



}

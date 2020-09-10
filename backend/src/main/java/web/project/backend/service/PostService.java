package web.project.backend.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.google.common.io.Resources;

import lombok.extern.log4j.Log4j2;
import web.project.backend.entity.Blog_post;
import web.project.backend.entity.Member;
import web.project.backend.repository.JpaBlogPostRepository;
import web.project.backend.repository.MemberRepository;
import web.project.backend.util.Base64Utils;
import web.project.backend.util.JsoupUtils;


@Transactional
@Service
@Log4j2
public class PostService {

	@Autowired
	private JpaBlogPostRepository postRepository;
	
	private static final String BLOG_IMAGE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\blogImage";
	private static final String DB_IMAGE_PATH = "http:\\\\localhost:8080\\blogImage\\";
	
	/*
	 * 포스트
	 * */
	public Blog_post getPost(Long blogId,Long postId) {
		
		Blog_post post = postRepository.findById(postId)
				.orElseThrow(() ->
                new UsernameNotFoundException("Post not found with PostId : " + postId));
		
		return post;
	}
	
	/*
	 * 블로그에서 넘어온 값 저장
	 * 
	 * */
	public boolean RegisterPost(Long userIdx, Blog_post post) throws Exception {
		
		String PostContent = post.getContent();
		
		List<String> images = JsoupUtils.ImageParser(PostContent);
		
		
		List<byte[]> byteImages = Base64Utils.decodeBase64ToBytes(images);
		List<String> ImageDBPath = new ArrayList<String>();
		String ImagePath = BLOG_IMAGE_PATH+"\\"+userIdx;
		
		if(MakeBlogDir(ImagePath))
		{
			Path path = Paths.get(ImagePath);

			try {
				for(int i=0;i<byteImages.size();i++)
				{
					if(byteImages.get(i) == null) 
						continue;
					
					String name = String.valueOf(i+1);
					
					if(images.get(i).startsWith(Base64Utils.BASE_64_PREFIX_GIF))
						name += ".gif";
					else if(images.get(i).startsWith(Base64Utils.BASE_64_PREFIX_JPEG))
						name += ".jpg";
					else if(images.get(i).startsWith(Base64Utils.BASE_64_PREFIX_PNG))
						name += ".png";
					
		            Files.copy(new ByteArrayInputStream(byteImages.get(i)), path.resolve(name));
		            ImageDBPath.add(DB_IMAGE_PATH+userIdx+"\\"+name);
				}
	        } catch (Exception e) {
	        	//Image 저장 실패
	            throw new Exception();
	        }
			
			for(int i=0;i<ImageDBPath.size();i++)
			{
				PostContent = PostContent.replace(images.get(i), ImageDBPath.get(i));
			}
		}
		
		Blog_post writePost = new Blog_post(userIdx, post.getTitle(), PostContent);
		
		try {
			postRepository.save(writePost);
			
			return true;
		} catch (Exception e) {
			//포스트 write 실패
			return false;
		}
		
	}
	
	private boolean MakeBlogDir(String path)
	{
		File Folder = new File(path);
		
		if(!Folder.exists()) {
			try {
				return Folder.mkdir();
			}
			catch (Exception e){
				log.error("폴더 생성에 실패하였습니다.");
				return false;
			}
		}
		else {
			return true;
		}
	}

}

package com.example.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.blog.blog.dao.BlogMapper;
import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;
import com.example.blog.service.BlogService;

/*
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void contextLoads() {
	}

}
*/

@ExtendWith(MockitoExtension.class)
class BlogApplicationTests {
	@Mock
	private BlogMapper blogMapper;

	@InjectMocks
	private BlogService blogService;

	@Test
	public void blogWriteGreen() { // 성공케이스
		// given
		BlogRequestDTO blogRequestDTO = BlogRequestDTO.builder()
													.title("test-title")
													.content("test-cont")
													.email("test@emil.com")
													.build();
		when(blogMapper.insertRow(blogRequestDTO)).thenReturn(1); //여기서 1은 성공의 데이터가 넘어옴을 의미
		
		
		// when
		int flag = blogService.write(blogRequestDTO);


		// then
		assertEquals(1, flag);
		verify(blogMapper).insertRow(blogRequestDTO);
	}

	@Test
	public void blogWriteRed() { // 실패케이스
	}
	
	@Test
	public void blogReadGreen() { // 성공케이스
		// given
		BlogResponseDTO blogResponseDTO = BlogResponseDTO.builder()
													.blogId(3)
													.build();
		when(blogMapper.readRow(3)).thenReturn(blogResponseDTO); 
		
		
		// when
		BlogResponseDTO result = blogService.read(3);


		// then
		assertEquals(3, result.getBlogId());
	}
	
	@Test
	public void blogListGreen() { // 성공케이스
		// given
		when(blogMapper.listRow()).thenReturn(List.of(
			BlogResponseDTO.builder().build(),
			BlogResponseDTO.builder().build()
		)); 
		
		// when
		List<BlogResponseDTO> list = blogService.list();

		// then
		assertEquals(2, list.size());
		verify(blogMapper).listRow();
	}
	
	@Test
	public void blogDeleteGreen() { // 성공케이스
		// given
		when(blogMapper.deleteRow(3)).thenReturn(1);  //여기서 1은 성공의 데이터가 넘어옴을 의미

		// when
		int result = blogService.delete(1);


		// then
		assertEquals(1, result);
	}
	
	@Test
	public void blogUpdateGreen() { // 성공케이스
		// given
		BlogRequestDTO blogRequestDTO = BlogRequestDTO.builder()
													.title("update-title")
													.content("update-cont")
													.build();
		when(blogMapper.updateRow(anyMap())).thenReturn(1);  //여기서 1은 성공의 데이터가 넘어옴을 의미

		// when
		int result = blogService.update(1, blogRequestDTO);


		// then
		assertEquals(1, result);
		verify(blogMapper).updateRow(argThat(map -> 
			map.get("blogId").equals(1)
			&&
			map.get("title").equals("update-title")
			&&
			map.get("content").equals("update-cont")
		));
	}
}
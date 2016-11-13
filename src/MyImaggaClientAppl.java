
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import tel_ran.imagga.entities.Image;



public class MyImaggaClientAppl {
	private static final String URL_GET = "http://localhost:8080/get_tags?url=https://im0-tub-ru.yandex.net/i?id=9a0f2948f2959e99f596f20571ec910d&n=33&h=215&w=382";
	private static final String URL_POST = "http://localhost:8080/get_images";
	private static final String URL_POST_QUERY = "http://localhost:8080/get_images_query";
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestGet = new HttpEntity<>(headers);
		ResponseEntity<String> response = 
				restTemplate.exchange(URL_GET, HttpMethod.GET, requestGet, String.class);
		System.out.println(response.getBody());
			
		String[] requestBody = {"car", "power", "motor", "auto", "speed", "road", "tree", "sky"};
		HttpEntity<String[]> requestPost = new HttpEntity<String[]>(requestBody, headers);
		ResponseEntity<List<Image>> responsePost =  restTemplate.exchange
				(URL_POST, HttpMethod.POST, requestPost,
						new ParameterizedTypeReference<List<Image>>() {});
		List<Image> res = responsePost.getBody();
		System.out.println(res.size());
		System.out.println(res);
		
		ResponseEntity<List<Image>> responsePostQuery =  restTemplate.exchange
				(URL_POST_QUERY, HttpMethod.POST, requestPost,
						new ParameterizedTypeReference<List<Image>>() {});
		List<Image> res1 = responsePostQuery.getBody();
		System.out.println(res1.size());
		System.out.println(res1);
	}

}

package com.ssafy.video.model.service;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.video.model.dto.Video;
import com.ssafy.video.model.repository.VideoRepository;
import com.ssafy.video.model.repository.VideoRepositoryImpl;

public class VideoServiceImpl implements VideoService{
	// DB에서 데이터를 가져와서 Service에서 처리하는 방식으로 코드를 작성하면 된다.
	private static VideoService service = new VideoServiceImpl();
	private VideoRepository repo = VideoRepositoryImpl.getInstance();
	
	// VideoServiceImpl 객체인 service를 하나만 생성하고, service를 통해서 하나의 데이터 모음을 활용한다.
	private VideoServiceImpl() {
	}
	
	public static VideoService getInstance() {
		return service;
	}
	
	
	
	@Override
	public List<Video> selectAll() {		
		return repo.selectAll();
	}

	@Override
	public List<Video> selectPopularVideos() {
		List<Video> allVideos = repo.selectAll();
		int N = allVideos.size();
		
		// 조회수를 기준으로 정렬한다.
		for(int i=0; i < N-1; i++) {
			for(int j=0; j<N-1-i; j++) {
				if(allVideos.get(j).getViewCnt()<allVideos.get(j+1).getViewCnt()) {
					Video temp = allVideos.get(j);
					allVideos.set(j, allVideos.get(j+1));
					allVideos.set(j+1, temp);
				}
			}	
		}
		
		
		List<Video> topVideos = new ArrayList<>();
		int Top = 3;
		for(int i=0; i< Top; i++) {
			topVideos.add(allVideos.get(i));
		}
		
		
		return topVideos;
	}

	@Override
	public List<Video> selectBodypartVideos(String fitBodyPart) {
		
		
		return null;
	}

	@Override
	public Video select(String youtubeId) {
		List<Video> allVideos = repo.selectAll();
		int N = allVideos.size();
		
		Video selVid = new Video();
		for(int i=0; i<N; i++) {
			if(allVideos.get(i).getYoutubeId().equals(youtubeId)) {
				selVid = allVideos.get(i);
			}
		}
		
		
		return selVid;
  }  


	@Override
	public boolean updateViewCnt(String youtubeId) {
		// 조회수가 업데이트 됐는지를 확인할 수 있는 boolean값을 되돌려주고, 실제 업데이트는 controller에서 하는 것이 좋을 것이다.
		// 조회수가 업데이트 안 됐을 때를 대비해서, boolean값만 받는 것이 좋을 것이다.
		return repo.updateViewCnt(youtubeId);
	}
	
	
	public void getReviewbyId(String youtubeId) {
		
		// db에서 가져와야 하므로 repo 호출  
		repo.getReviewbyId(youtubeId);
	}	

}

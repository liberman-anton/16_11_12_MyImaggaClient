package tel_ran.imagga.entities;

import java.util.*;


public class Image {
	
	String image;
	List<Tag> tags;
	
	public Image(String image, List<Tag> tags) {
		super();
		this.image = image;
		this.tags = tags;
	}
	public Image() {
		super();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Image [image=" + image + ", tags=" + tags + "]";
	}
	
}

package dto;

public class PageDTO {

	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	public PageDTO(int page, int maxPage, int startPage, int endPage) {
		super();
		this.page = page;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public PageDTO() {
		super();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageDTO [page=" + page + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ "]";
	}
}

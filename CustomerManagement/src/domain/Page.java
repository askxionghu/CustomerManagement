package domain;

import java.util.List;

//������װ��ҳ����
public class Page {
	
	private List<Customer> list;
	private int totalPage; //��¼��ҳ��
	private int totalRecord; //��¼�ܼ�¼����Ҫ�����ݿ��Ǳ߻�ȡ��
	private int pageSize = 5; //����ÿҳ��ʾ5����Ϣ
	private int pageNum; //��ʾ�û��뿴��ҳ
	private int startIndex; //�����û��뿴��ҳ�����ݴ����ݿ���ĸ��ط���ʼȡ
	
	private int startPage; //��סjspҳ����ʾ����ʼҳ��
	private int endPage; //��סjspҳ����ʾ�Ľ���ҳ��
	
	private String url; // ��¼���ڴ����ҳ��servlet
	
	public Page(int totalRecord, int pageNum){
		this.totalRecord = totalRecord;
		this.pageNum = pageNum;
		
		//������ҳ��
		if(this.totalRecord % this.pageSize == 0){
			this.totalPage = this.totalRecord / this.pageSize;
		} else {
			this.totalPage = this.totalRecord / this.pageSize + 1;
		}
		
		//�����û��뿴��ҳ�����ݴ����ݿ��ĸ��ط���ʼȡ
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		
		//�����û��뿴��ҳ������jsp��ʾ����ʼҳ��ͽ���ҳ�롣�������д����ʾ��5��ҳ��
		if(this.totalPage <= 6){
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.pageNum - 2;
			this.endPage = this.pageNum + 3;
			
			if(this.startPage < 1){
				this.startPage = 1;
				this.endPage = 6;
			}
			
			if(this.endPage > this.totalPage){
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 5;
			}
		}	
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

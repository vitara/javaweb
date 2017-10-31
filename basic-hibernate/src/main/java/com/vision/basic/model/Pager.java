package com.vision.basic.model;

import java.util.List;

public class Pager<T> {
	/**
	 * 分页对象
	 * 分页大小
	 */
	private int Size;
	/*
	 * 起始大小
	 */
	private int offset;
	/*
	 * 总记录数
	 */
	private long total;
	/*
	 * 分页的数据
	 */
	private List<T> datas;
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
}

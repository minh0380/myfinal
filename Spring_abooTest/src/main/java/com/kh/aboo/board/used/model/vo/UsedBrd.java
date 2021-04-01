package com.kh.aboo.board.used.model.vo;

public class UsedBrd {

	private String usedIdx;
	private String apartmentIdx;
	private String usedTitle;
	private String usedContent;
	private String usedWriter;
	private String usedRegDate;
	private String isDel;
	private String isTransc;
	private String isPrivate;
	private String generationIdx;

	public UsedBrd() {

	}

	public UsedBrd(String usedIdx, String apartmentIdx, String usedTitle, String usedContent, String usedWriter,
			String usedRegDate, String isDel, String isTransc, String isPrivate, String generationIdx) {
		super();
		this.usedIdx = usedIdx;
		this.apartmentIdx = apartmentIdx;
		this.usedTitle = usedTitle;
		this.usedContent = usedContent;
		this.usedWriter = usedWriter;
		this.usedRegDate = usedRegDate;
		this.isDel = isDel;
		this.isTransc = isTransc;
		this.isPrivate = isPrivate;
		this.generationIdx = generationIdx;
	}

	public String getUsedIdx() {
		return usedIdx;
	}

	public void setUsedIdx(String usedIdx) {
		this.usedIdx = usedIdx;
	}

	public String getApartmentIdx() {
		return apartmentIdx;
	}

	public void setApartmentIdx(String apartmentIdx) {
		this.apartmentIdx = apartmentIdx;
	}

	public String getUsedTitle() {
		return usedTitle;
	}

	public void setUsedTitle(String usedTitle) {
		this.usedTitle = usedTitle;
	}

	public String getUsedContent() {
		return usedContent;
	}

	public void setUsedContent(String usedContent) {
		this.usedContent = usedContent;
	}

	public String getUsedWriter() {
		return usedWriter;
	}

	public void setUsedWriter(String usedWriter) {
		this.usedWriter = usedWriter;
	}

	public String getUsedRegDate() {
		return usedRegDate;
	}

	public void setUsedRegDate(String usedRegDate) {
		this.usedRegDate = usedRegDate;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getIsTransc() {
		return isTransc;
	}

	public void setIsTransc(String isTransc) {
		this.isTransc = isTransc;
	}

	public String getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(String isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getGenerationIdx() {
		return generationIdx;
	}

	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}

	@Override
	public String toString() {
		return "UsedBrd [usedIdx=" + usedIdx + ", apartmentIdx=" + apartmentIdx + ", usedTitle=" + usedTitle
				+ ", usedContent=" + usedContent + ", usedWriter=" + usedWriter + ", usedRegDate=" + usedRegDate
				+ ", isDel=" + isDel + ", isTransc=" + isTransc + ", isPrivate=" + isPrivate + ", generationIdx="
				+ generationIdx + "]";
	}

}

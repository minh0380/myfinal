package com.kh.aboo.user.generationWon.model.vo;

public class GenerationWon {

	private String generationWonIdx;
	private String generationIdx;
	private String tell;
	private String name;
	private String isDel;

	public GenerationWon() {

	}

	public GenerationWon(String generationWonIdx, String generationIdx, String tell, String name, String isDel) {
		super();
		this.generationWonIdx = generationWonIdx;
		this.generationIdx = generationIdx;
		this.tell = tell;
		this.name = name;
		this.isDel = isDel;
	}

	public String getGenerationWonIdx() {
		return generationWonIdx;
	}

	public void setGenerationWonIdx(String generationWonIdx) {
		this.generationWonIdx = generationWonIdx;
	}

	public String getGenerationIdx() {
		return generationIdx;
	}

	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "GenerationWon [generationWonIdx=" + generationWonIdx + ", generationIdx=" + generationIdx + ", tell="
				+ tell + ", name=" + name + ", isDel=" + isDel + "]";
	}

}

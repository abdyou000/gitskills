package com.huat.searchengine.entity;

public class TblExpert {
    private String expertId;

    private String expertName;

    private String expertAddress;

    private String expertJob;

    private Integer articleQuantity;

    private Integer articleOriginal;

    private Integer readingQuantity;

    private Integer fansQuantity;

    private Integer likeQunatity;

    private Integer commentQuantity;

    private Integer focusQuantity;

    private String blogAddress;

    private String blogTitle;

    private String personalCenter;

    private String expertAvatar;

    private Integer blogGrade;

    private Integer blogScore;

    private Integer downloadGrade;

    private Integer downloadScore;

    private Integer bbsGrade;

    private Integer bbsScore;

    private String expertMedals;

    private Integer expertRanking;

    private String nickName;

    private String expertSign;

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId == null ? null : expertId.trim();
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName == null ? null : expertName.trim();
    }

    public String getExpertAddress() {
        return expertAddress;
    }

    public void setExpertAddress(String expertAddress) {
        this.expertAddress = expertAddress == null ? null : expertAddress.trim();
    }

    public String getExpertJob() {
        return expertJob;
    }

    public void setExpertJob(String expertJob) {
        this.expertJob = expertJob == null ? null : expertJob.trim();
    }

    public Integer getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(Integer articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public Integer getArticleOriginal() {
        return articleOriginal;
    }

    public void setArticleOriginal(Integer articleOriginal) {
        this.articleOriginal = articleOriginal;
    }

    public Integer getReadingQuantity() {
        return readingQuantity;
    }

    public void setReadingQuantity(Integer readingQuantity) {
        this.readingQuantity = readingQuantity;
    }

    public Integer getFansQuantity() {
        return fansQuantity;
    }

    public void setFansQuantity(Integer fansQuantity) {
        this.fansQuantity = fansQuantity;
    }

    public Integer getLikeQunatity() {
        return likeQunatity;
    }

    public void setLikeQunatity(Integer likeQunatity) {
        this.likeQunatity = likeQunatity;
    }

    public Integer getCommentQuantity() {
        return commentQuantity;
    }

    public void setCommentQuantity(Integer commentQuantity) {
        this.commentQuantity = commentQuantity;
    }

    public Integer getFocusQuantity() {
        return focusQuantity;
    }

    public void setFocusQuantity(Integer focusQuantity) {
        this.focusQuantity = focusQuantity;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress == null ? null : blogAddress.trim();
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getPersonalCenter() {
        return personalCenter;
    }

    public void setPersonalCenter(String personalCenter) {
        this.personalCenter = personalCenter == null ? null : personalCenter.trim();
    }

    public String getExpertAvatar() {
        return expertAvatar;
    }

    public void setExpertAvatar(String expertAvatar) {
        this.expertAvatar = expertAvatar == null ? null : expertAvatar.trim();
    }

    public Integer getBlogGrade() {
        return blogGrade;
    }

    public void setBlogGrade(Integer blogGrade) {
        this.blogGrade = blogGrade;
    }

    public Integer getBlogScore() {
        return blogScore;
    }

    public void setBlogScore(Integer blogScore) {
        this.blogScore = blogScore;
    }

    public Integer getDownloadGrade() {
        return downloadGrade;
    }

    public void setDownloadGrade(Integer downloadGrade) {
        this.downloadGrade = downloadGrade;
    }

    public Integer getDownloadScore() {
        return downloadScore;
    }

    public void setDownloadScore(Integer downloadScore) {
        this.downloadScore = downloadScore;
    }

    public Integer getBbsGrade() {
        return bbsGrade;
    }

    public void setBbsGrade(Integer bbsGrade) {
        this.bbsGrade = bbsGrade;
    }

    public Integer getBbsScore() {
        return bbsScore;
    }

    public void setBbsScore(Integer bbsScore) {
        this.bbsScore = bbsScore;
    }

    public String getExpertMedals() {
        return expertMedals;
    }

    public void setExpertMedals(String expertMedals) {
        this.expertMedals = expertMedals == null ? null : expertMedals.trim();
    }

    public Integer getExpertRanking() {
        return expertRanking;
    }

    public void setExpertRanking(Integer expertRanking) {
        this.expertRanking = expertRanking;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getExpertSign() {
        return expertSign;
    }

    public void setExpertSign(String expertSign) {
        this.expertSign = expertSign == null ? null : expertSign.trim();
    }

	@Override
	public String toString() {
		return "TblExpert [expertId=" + expertId + ", expertName=" + expertName + ", expertAddress=" + expertAddress
				+ ", expertJob=" + expertJob + ", articleQuantity=" + articleQuantity + ", articleOriginal="
				+ articleOriginal + ", readingQuantity=" + readingQuantity + ", fansQuantity=" + fansQuantity
				+ ", likeQunatity=" + likeQunatity + ", commentQuantity=" + commentQuantity + ", focusQuantity="
				+ focusQuantity + ", blogAddress=" + blogAddress + ", blogTitle=" + blogTitle + ", personalCenter="
				+ personalCenter + ", expertAvatar=" + expertAvatar + ", blogGrade=" + blogGrade + ", blogScore="
				+ blogScore + ", downloadGrade=" + downloadGrade + ", downloadScore=" + downloadScore + ", bbsGrade="
				+ bbsGrade + ", bbsScore=" + bbsScore + ", expertMedals=" + expertMedals + ", expertRanking="
				+ expertRanking + ", nickName=" + nickName + ", expertSign=" + expertSign + "]";
	}
    
   
}
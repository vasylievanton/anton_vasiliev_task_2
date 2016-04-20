package com.task2.vasilyevanton.task_2.data;

public class AppealsData {

    private String mItemLikes;
    private String mItemAddress;
    private String mItemRegisterDate;
    private String mItemCreationDate;
    private String mItemDeadlineDate;
    private String mItemId;
    private String mItemStatus;
    private String mItemExecutor;
    private String mItemDescription;
    private int[] itemImageRef;

    public String getmItemLikes() {
        return mItemLikes;
    }

    //
    public AppealsData() {
        this.mItemLikes = null;
        this.mItemAddress = null;
        this.mItemRegisterDate = null;
        this.mItemCreationDate = null;
        this.mItemDeadlineDate = null;
        this.mItemId = null;
        this.mItemStatus = null;
        this.mItemExecutor = null;
        this.mItemDescription = null;
        this.itemImageRef = null;
    }

    public int[] getItemImageRef() {
        return itemImageRef;
    }

    public void setItemImageRef(int[] itemImageRef) {
        this.itemImageRef = itemImageRef;
    }

    public String getmItemDescription() {
        return mItemDescription;
    }

    public void setmItemDescription(String mItemDescription) {
        this.mItemDescription = mItemDescription;
    }

    public String getmItemStatus() {
        return mItemStatus;
    }

    public void setmItemStatus(String mItemStatus) {
        this.mItemStatus = mItemStatus;
    }

    public String getmItemExecutor() {
        return mItemExecutor;
    }

    public void setmItemExecutor(String mItemExecutor) {
        this.mItemExecutor = mItemExecutor;
    }

    public String getmItemAddress() {
        return mItemAddress;
    }

    public void setmItemAddress(String mItemAddress) {
        this.mItemAddress = mItemAddress;
    }

    public String getmItemRegisterDate() {
        return mItemRegisterDate;
    }

    public void setmItemRegisterDate(String mItemRegisterDate) {
        this.mItemRegisterDate = mItemRegisterDate;
    }

    public String getmItemCreationDate() {
        return mItemCreationDate;
    }

    public void setmItemCreationDate(String mItemCreationDate) {
        this.mItemCreationDate = mItemCreationDate;
    }

    public String getmItemDeadlineDate() {
        return mItemDeadlineDate;
    }

    public void setmItemExecTerm(String mItemDeadlineDate) {
        this.mItemDeadlineDate = mItemDeadlineDate;
    }

    public String getmItemId() {
        return mItemId;
    }

    public void setmItemId(String mItemId) {
        this.mItemId = mItemId;
    }

    public String getItemName() {
        return mItemLikes;
    }

    public void setmItemLikes(String likes) {
        this.mItemLikes = likes;
    }
}

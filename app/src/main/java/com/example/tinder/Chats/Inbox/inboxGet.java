package com.example.tinder.Chats.Inbox;

public class inboxGet {

    Boolean isItMe;
    String  messageSentmessageSentTime;
    String messageReceived;
    String messageReceivedTime;
    int userImage;
    String messageSent;

    public Boolean getItMe() {
        return isItMe;
    }

    public void setItMe(Boolean itMe) {
        isItMe = itMe;
    }

    public String getMessageSentmessageSentTime() {
        return messageSentmessageSentTime;
    }

    public void setMessageSentmessageSentTime(String messageSentmessageSentTime) {
        this.messageSentmessageSentTime = messageSentmessageSentTime;
    }

    public String getMessageReceived() {
        return messageReceived;
    }

    public void setMessageReceived(String messageReceived) {
        this.messageReceived = messageReceived;
    }

    public String getMessageReceivedTime() {
        return messageReceivedTime;
    }

    public void setMessageReceivedTime(String messageReceivedTime) {
        this.messageReceivedTime = messageReceivedTime;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getMessageSent() {
        return messageSent;
    }

    public void setMessageSent(String messageSent) {
        this.messageSent = messageSent;
    }
}

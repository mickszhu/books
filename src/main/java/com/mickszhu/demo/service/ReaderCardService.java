package com.mickszhu.demo.service;


import com.mickszhu.demo.dao.ReaderCardDao;
import com.mickszhu.demo.dto.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderCardService {
    @Autowired
    private ReaderCardDao readerCardDao;

    public boolean addReaderCard(ReaderInfo readerInfo, String password){
        return  readerCardDao.addReaderCard(readerInfo,password)>0;
    }
    public boolean updatePassword(long readerId, String password){
        return readerCardDao.resetPassword(readerId,password)>0;
    }

    public boolean deleteReaderCard(long readerId) {
        return readerCardDao.deleteReaderCard(readerId) > 0;
    }
}

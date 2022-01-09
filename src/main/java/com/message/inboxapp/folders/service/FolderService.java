package com.message.inboxapp.folders.service;

import com.message.inboxapp.folders.model.Folder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FolderService {

    public List<Folder> fetchDefaultFolders(String userId){
        return Arrays.asList(
                new Folder(userId, "Inbox", "blue"),
                new Folder(userId,"Sent Items","green"),
                new Folder(userId, "Trash","orange")
        );
    }
}

package com.andyron.arblog.service;

import com.andyron.arblog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Tag getTag(Long id);

    Tag saveTag(Tag tag);

    Tag updateTage(Long id, Tag tag);

    void deleteTage(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    /**
     *
     * @param ids  1,2,3
     * @return
     */
    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);
}

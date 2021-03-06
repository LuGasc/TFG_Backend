package com.lucia.nft.repositories;

import java.util.List;

import com.lucia.nft.entities.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query(value = "SELECT img FROM Image img WHERE img.user.id IN :ids ORDER BY img.createdDate DESC")
    List<Image> findImages(@Param("ids") Long ids);

    @Query(value = "SELECT img FROM Image img WHERE img.hash LIKE :hash")
    Image findImage(@Param("hash") String hash);
}

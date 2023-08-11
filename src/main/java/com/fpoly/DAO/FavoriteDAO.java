package com.fpoly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Favorite;
@Repository
public interface FavoriteDAO extends JpaRepository<Favorite, Integer>{

}

package com.generation.blogpessoal.repository;

//@Repository
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.blogpessoal.model.Postagem;
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}

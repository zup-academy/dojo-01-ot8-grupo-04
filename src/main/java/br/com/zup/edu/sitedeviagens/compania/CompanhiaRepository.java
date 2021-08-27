package br.com.zup.edu.sitedeviagens.compania;

import br.com.zup.edu.sitedeviagens.compania.Companhia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanhiaRepository extends JpaRepository<Companhia, Long> {


}

package com.squad2.security;

import com.squad2.model.Municipio;
import com.squad2.repository.MunicipioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MunicipioDetailsService implements UserDetailsService {

    private final MunicipioRepository municipioRepository;

    public MunicipioDetailsService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Municipio municipio = municipioRepository.findByUsuario(usuario)
            .orElseThrow(() -> new UsernameNotFoundException("Município não encontrado"));
        return User.builder()
            .username(municipio.getUsuario())
            .password(municipio.getSenha())
            .roles("MUNICIPIO")
            .build();
    }
}
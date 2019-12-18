package com.baufest.Libreria.repository;

import com.baufest.Libreria.models.Factura;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FacturaRepository implements JpaRepository<Factura, Integer> {

    @Override
    public List<Factura> findAll() {
        return null;
    }

    @Override
    public List<Factura> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Factura> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Factura> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Factura factura) {

    }

    @Override
    public void deleteAll(Iterable<? extends Factura> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Factura> S save(S s) {
        return null;
    }

    @Override
    public <S extends Factura> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Factura> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Factura> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Factura> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Factura getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Factura> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Factura> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Factura> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Factura> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Factura> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Factura> boolean exists(Example<S> example) {
        return false;
    }
}

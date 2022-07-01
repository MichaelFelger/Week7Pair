package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cards")

public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;
    private List<CatCard> catcards = new ArrayList<>();

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> list(){
        return catCardDao.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id) {
        return catCardDao.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard getPic() {
        CatCard newRandomCard = new CatCard();
        newRandomCard.setImgUrl(catPicService.getPic().getFile());
        newRandomCard.setCatFact(catFactService.getFact().getText());
        return newRandomCard;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public boolean save(@RequestBody CatCard catCard) {
        return catCardDao.save(catCard);
    }



    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody @Valid CatCard catCard, @PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.update(id, catCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.delete(id);
    }

}


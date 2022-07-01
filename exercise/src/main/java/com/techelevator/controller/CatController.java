package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import com.techelevator.services.RestCatPicService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cards/")

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

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> list(){
        catcards.get
    }

    @RequestMapping(path = "random", method = RequestMethod.GET)
    public CatCard getPic() {
        CatCard newRandomCard = new CatCard();
        newRandomCard.setImgUrl(catPicService.getPic().getFile());
        newRandomCard.setCatFact(catFactService.getFact().getText());
        return newRandomCard;
    }


}


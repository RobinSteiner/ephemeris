import {Component, OnInit} from '@angular/core';
import {CardsService} from './cards.service';
import {Card} from './card';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  cards: Array<Card>;

  constructor(private cardsService: CardsService) {
  }

  ngOnInit() {
    this.cardsService.getCards(new Date()).subscribe((cards) => {
      this.cards = cards;
      console.log(cards);
    });
  }

}

import {Component, Input, OnInit} from '@angular/core';
import {Card, ImageCard, MusicCard, TextCard} from '../card';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input() public card: Card;

  constructor() { }

  ngOnInit() {
  }

  isTextCard(): boolean {
    return (this.card instanceof TextCard);
  }

  isMusicCard(): boolean {
    return (this.card instanceof MusicCard);
  }

  isImageCard(): boolean {
    return (this.card instanceof ImageCard);
  }

}

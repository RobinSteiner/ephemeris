import {Component, Input, OnInit} from '@angular/core';
import {TextCard} from '../card';

@Component({
  selector: 'app-text-card',
  templateUrl: './text-card.component.html',
  styleUrls: ['./text-card.component.css']
})
export class TextCardComponent implements OnInit {

  @Input() public card: TextCard;

  constructor() { }

  ngOnInit() {
  }

}

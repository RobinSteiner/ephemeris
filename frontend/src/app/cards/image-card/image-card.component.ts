import {Component, Input, OnInit} from '@angular/core';
import {ImageCard} from '../card';

@Component({
  selector: 'app-image-card',
  templateUrl: './image-card.component.html',
  styleUrls: ['./image-card.component.css']
})
export class ImageCardComponent implements OnInit {

  @Input() public card: ImageCard;

  constructor() { }

  ngOnInit() {
  }

}

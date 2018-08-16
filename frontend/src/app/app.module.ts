import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TextCardComponent} from './cards/text-card/text-card.component';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle, MatGridList, MatGridTile} from '@angular/material';
import {CardsComponent} from './cards/cards.component';
import {CardComponent} from './cards/card/card.component';
import {HttpClientModule} from '@angular/common/http';
import {ImageCardComponent} from './cards/image-card/image-card.component';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  declarations: [
    AppComponent,
    MatCard, MatCardTitle, MatCardContent, MatCardHeader, MatGridList, MatGridTile,
    TextCardComponent,
    CardsComponent,
    CardComponent,
    ImageCardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

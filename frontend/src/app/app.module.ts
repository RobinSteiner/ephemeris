import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TextCardComponent } from './cards/text-card/text-card.component';
import {MatCard} from '@angular/material';
import { CardsComponent } from './cards/cards.component';
import { CardComponent } from './cards/card/card.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MatCard,
    TextCardComponent,
    CardsComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

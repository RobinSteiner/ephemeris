export class Card {
  id: number;
  date: Date;
  order: number;
  rows: number;
  cols: number;
  type: string;
}

enum Theme { Lite, Dark }
enum LocationMode { Place, Map }
enum MusicMode { Big, Small }

export class TextCard extends Card {
  text: string;
  title: string;
  backgroundColor: string;
  foregroundColor: string;
}
export class ImageCard extends Card {
  source: string;
}

export class VideoCard extends Card {
  source: string;
}

export class YoutubeCard extends Card {
}

export class MusicCard extends Card {
  source: string;
}

export class SpotifyCard extends Card {
  theme: Theme;
  mode: MusicMode;
}

export class LocationCard extends Card {
  longitude: number;
  latitude: number;
  place: string;
  mode: LocationMode;
}

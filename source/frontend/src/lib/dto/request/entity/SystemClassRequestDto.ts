export class SystemClassRequestDto {

  id: string = "";
  title: string = "";
  cyber: boolean = true;

  constructor() { }

  static create() {
    return new SystemClassRequestDto();
  }
}

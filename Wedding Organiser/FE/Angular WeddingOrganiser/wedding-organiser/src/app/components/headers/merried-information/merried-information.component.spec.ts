import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerriedInformationComponent } from './merried-information.component';

describe('MerriedInformationComponent', () => {
  let component: MerriedInformationComponent;
  let fixture: ComponentFixture<MerriedInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerriedInformationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerriedInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

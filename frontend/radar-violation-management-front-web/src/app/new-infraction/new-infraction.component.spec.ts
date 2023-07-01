import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewInfractionComponent } from './new-infraction.component';

describe('NewInfractionComponent', () => {
  let component: NewInfractionComponent;
  let fixture: ComponentFixture<NewInfractionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewInfractionComponent]
    });
    fixture = TestBed.createComponent(NewInfractionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
